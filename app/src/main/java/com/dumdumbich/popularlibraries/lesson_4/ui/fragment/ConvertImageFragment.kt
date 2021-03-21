package com.dumdumbich.popularlibraries.lesson_4.ui.fragment

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.dumdumbich.popularlibraries.databinding.FragmentConvertImageBinding
import com.dumdumbich.popularlibraries.lesson_4.model.converter.Image
import com.dumdumbich.popularlibraries.lesson_4.presenter.ConvertImagePresenter
import com.dumdumbich.popularlibraries.lesson_4.ui.App
import com.dumdumbich.popularlibraries.lesson_4.ui.IBackClickListener
import com.dumdumbich.popularlibraries.lesson_4.ui.converter.AndroidConverter
import com.dumdumbich.popularlibraries.lesson_4.ui.navigation.AndroidScreens
import com.dumdumbich.popularlibraries.lesson_4.view.IConvertImageView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ConvertImageFragment : MvpAppCompatFragment(), IConvertImageView, IBackClickListener {

    companion object {
        private const val SELECT_IMAGE_REQUEST_ID = 777
        fun newInstance() = ConvertImageFragment()
    }

    private val presenter by moxyPresenter {
        ConvertImagePresenter(
            App.instance.router,
            AndroidScreens(),
            AndroidSchedulers.mainThread(),
            AndroidConverter(context)
        )
    }

    private var ui: FragmentConvertImageBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentConvertImageBinding.inflate(inflater, container, false).also {
        ui = it
        Log.d("CONVERTER","ConverterImageFragment : onCreateView()")
    }.root

    override fun selectImage() {
        Log.d("CONVERTER","ConverterImageFragment : selectImage()")
        val intent = Intent().apply {
            type = "image/*"
            action = Intent.ACTION_GET_CONTENT
        }
        startActivityForResult(
            Intent.createChooser(intent, "Select image file"),
            SELECT_IMAGE_REQUEST_ID
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d("CONVERTER","ConverterImageFragment : onActivityResult()")
        if (requestCode == SELECT_IMAGE_REQUEST_ID) {
            if (resultCode == Activity.RESULT_OK) {
                data?.data?.let { uri ->
                    val bytes = context?.contentResolver?.openInputStream(uri)?.buffered()
                        ?.use { it.readBytes() }
                    bytes?.let {
                        presenter.imageSelected(Image(bytes))
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun init() {
        ui?.btnSelectAndConvert?.setOnClickListener {
            Log.d("CONVERTER","ConverterImageFragment : init()")
            presenter.selectAndConvertImageClick()
        }
    }

    var convertInProgressDialog: Dialog? = null
    override fun showConvertInProgress() {
        context?.let {
            convertInProgressDialog = AlertDialog.Builder(it)
                .setMessage("Conversion in progress...")
                .setNegativeButton("Cancel") { _, _ -> presenter.convertCancel() }
                .create()
            convertInProgressDialog?.show()
        }
    }

    override fun hideConvertInProgress() {
        convertInProgressDialog?.dismiss()
    }

    override fun showConvertSuccess() {
        Toast.makeText(context, "The conversion was completed with an success", Toast.LENGTH_SHORT)
            .show()
    }

    override fun showConvertCancel() {
        Toast.makeText(context, "The conversion was cancelled", Toast.LENGTH_SHORT).show()
    }

    override fun showConvertError() {
        Toast.makeText(context, "The conversion was completed with an error", Toast.LENGTH_SHORT)
            .show()
    }

    override fun isBackPressed() = presenter.backClick()

}
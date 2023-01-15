package com.example.androidprojecthomework.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.FragmentLoginBinding
import com.example.androidprojecthomework.utils.NavHelper.navigateWithBundel
import com.example.androidprojecthomework.utils.NavHelper.navigateWithDeleteBack
import com.example.androidprojecthomework.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.nav.observe(viewLifecycleOwner){
            if (it != null){
                navigateWithDeleteBack(
                    it.destinationId,
                    it.removeFragment
                )
            }
        }

        viewBinding.button.setOnClickListener {
            if (viewBinding.editText.text.toString().isEmpty() || viewBinding.editText.length()>10 || viewBinding.editText.length()<5){
                viewBinding.editText.error = getString(R.string.error_login)
            }else if (viewBinding.editText2.text.toString().isEmpty() || viewBinding.editText2.length()>10 || viewBinding.editText2.length()<5){
                viewBinding.editText2.error = getString(R.string.error_password)
            } else {
                viewModel.loginUser(
                    viewBinding.editText.text.toString(),
                    viewBinding.editText2.text.toString()
                )
            }
        }


        viewModel.msg.observe(viewLifecycleOwner){
            Toast.makeText(context, getString(R.string.msg), Toast.LENGTH_SHORT).show()
        }
    }
}
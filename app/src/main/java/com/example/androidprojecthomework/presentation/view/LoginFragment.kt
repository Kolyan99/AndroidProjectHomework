package com.example.androidprojecthomework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.FragmentLoginBinding
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



        viewBinding.button.setOnClickListener {
            viewModel.loginUser(
                viewBinding.editText.text.toString(),
                viewBinding.editText2.text.toString()
            )
            if (viewBinding.editText.text.toString().isEmpty() || viewBinding.editText.length()>10 || viewBinding.editText.length()<5){
                viewBinding.editText.error = getString(R.string.error_login)
            }else if (viewBinding.editText2.text.toString().isEmpty() || viewBinding.editText2.length()>10 || viewBinding.editText2.length()<5){
                viewBinding.editText2.error = getString(R.string.error_password)
            } else {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, ItemsFragment())
                    .commit()
            }
        }

        viewModel.nav.observe(viewLifecycleOwner){
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, HomeFragment())
        }
        viewModel.msg.observe(viewLifecycleOwner){
            Toast.makeText(context, getString(R.string.msg), Toast.LENGTH_SHORT).show()
        }
    }
}
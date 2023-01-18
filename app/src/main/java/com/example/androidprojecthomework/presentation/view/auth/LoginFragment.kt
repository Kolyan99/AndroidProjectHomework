package com.example.androidprojecthomework.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidprojecthomework.databinding.FragmentLoginBinding
import com.example.androidprojecthomework.utils.NavHelp.navigateWithDeleteBackStack
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginView {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var loginPresenter: LoginPresenter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginPresenter.setView(this)


        viewBinding.button.setOnClickListener {
            loginPresenter.loginUser(
                viewBinding.editText.text.toString(),
                viewBinding.editText2.text.toString()
            )
        }
    }

    override fun userLogged(destination: Int, fragmentRemove: Int) {
        navigateWithDeleteBackStack(destination,fragmentRemove)
    }
}


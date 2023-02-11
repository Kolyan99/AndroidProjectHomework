package com.example.androidprojecthomework.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidprojecthomework.App
import com.example.androidprojecthomework.R
import com.example.androidprojecthomework.databinding.FragmentLoginBinding
import com.example.androidprojecthomework.di.PresentationModule
import javax.inject.Inject


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

        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        loginPresenter.setView(this)


        viewBinding.button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, HomeFragment())
                .commit()
            loginPresenter.loginUser(
                viewBinding.editText.text.toString(),
                viewBinding.editText2.text.toString(),
            )
        }
    }


 // override fun userLogged(destination: Int, fragmentRemove: Int) {
    //    navigateWithDeleteBackStack(destination,fragmentRemove)
   // }
}


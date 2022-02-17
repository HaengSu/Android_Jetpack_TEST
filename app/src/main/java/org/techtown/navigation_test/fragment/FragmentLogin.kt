package org.techtown.navigation_test.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import org.techtown.navigation_test.R
import org.techtown.navigation_test.databinding.FragmentLoginBinding

class FragmentLogin : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    var mBinding: FragmentLoginBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

//        binding.tvKakao.setOnClickListener(this)
//        binding.tvGoogle.setOnClickListener(this)
        binding.tvGuest.setOnClickListener(this)


    }

    override fun onClick(v : View?) {
        when(v?.id) {
            R.id.tv_guest -> {
                navController.navigate(R.id.action_fragmentLogin_to_fragment_main)
            }
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}





























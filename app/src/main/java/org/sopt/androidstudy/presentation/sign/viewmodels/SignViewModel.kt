package org.sopt.androidstudy.presentation.sign.viewmodels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class SignViewModel() : ViewModel() {
    private val userEmail = MutableLiveData<String>()
    private val userPassword = MutableLiveData<String>()
    private val isEnabledButton = MediatorLiveData<Boolean>()
    private val isVaildEmail = MutableLiveData<Boolean>()
    private val isVaildPassword = MutableLiveData<Boolean>()
    private val isSuccess = MutableLiveData<Boolean>()

    init {
        initEnabledLoginButton()
    }

    private fun initEnabledLoginButton() {
        isEnabledButton.addSource(isVaildEmail) {
            isEnabledButton.value = combineUserVaild(it, isVaildPassword.value)
        }
        isEnabledButton.addSource(isVaildPassword) {
            isEnabledButton.value = combineUserVaild(isVaildEmail.value, it)
        }
    }


    fun onEmailTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        userEmail.value = s.toString().trim()
        checkEmailFormat()
    }

    fun onPasswordTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        userPassword.value = s.toString().trim()
        checkPasswordFormat()
    }

    private fun checkEmailFormat() {
        val emailPattern = Patterns.EMAIL_ADDRESS
        isVaildEmail.value = emailPattern.matcher(userEmail.value).matches()
    }

    private fun checkPasswordFormat() {
        val passwordPattern =
            Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{7,15}.$")
        isVaildPassword.value = passwordPattern.matcher(userPassword.value).matches()
    }

    private fun combineUserVaild(emailValid: Boolean?, passwordValid: Boolean?): Boolean {
        if (isVaildEmail.value == null || isVaildPassword.value == null) {
            return false
        }
        return isVaildEmail.value == true && isVaildPassword.value == true
    }

    fun getUserEmail(): LiveData<String> = userEmail
    fun getUserPassword(): LiveData<String> = userPassword
    fun getVaildEmail(): LiveData<Boolean?> = isVaildEmail
    fun getEnabledButton(): LiveData<Boolean> = isEnabledButton
    fun getVaildPassword(): LiveData<Boolean> = isVaildPassword
    fun getSuccess(): LiveData<Boolean> = isSuccess
}

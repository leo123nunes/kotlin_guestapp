package com.leo123nunes.guestapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.leo123nunes.guestapp.R
import com.leo123nunes.guestapp.viewModel.GuestFormViewModel
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
        observers()
    }

    fun observers(){
        viewModel.savedGuest.observe(this, Observer{
            if(it == true){
                Toast.makeText(applicationContext,"Convidado adicionado.",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext,"Convidado não confirmado.",Toast.LENGTH_LONG).show()
            }
            finish()
        })
    }

    fun setListeners(){
        buttonSave.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        var id = v.id
        if (id == R.id.buttonSave){
            viewModel.saveGuest(guestName.text.toString(),button_presence.isChecked())
        }
    }
}
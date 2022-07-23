package com.happinessjames.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.happinessjames.mycontacts.databinding.ActivityViewContactBinding
import com.squareup.picasso.Picasso

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }
    fun getExtras(){
        var name = intent.extras?.getString("NAME")
        var address = intent.extras?.getString("ADDRESS")
        var email= intent.extras?.getString("EMAIL")
        var phonenumber= intent.extras?.getString("PHONENUMBER")
        var image = binding.ivProfile


//        Toast.makeText(this,name,Toast.LENGTH_LONG).show()
//        Toast.makeText(this,address,Toast.LENGTH_LONG).show()
//        Toast.makeText(this,email,Toast.LENGTH_LONG).show()
//        Toast.makeText(this,phonenumber,Toast.LENGTH_LONG).show()

        binding.tvName1.text = name
        binding.tvContact.text = email
        binding.tvAddress1.text = address
        binding.tvEmail.text = phonenumber

        Picasso.get().load(intent.getStringExtra("IMAGE"))
            .resize(1200,700)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(image)

    }
}
package com.happinessjames.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.happinessjames.mycontacts.databinding.ContactsListItemBinding
import com.squareup.picasso.Picasso

class ContactRvAdapter (var contactsList: List<Contacts>): RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding = ContactsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
      return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
       var currentContacts = contactsList.get(position)
        holder.binding.tvName.text = currentContacts.name
        holder.binding.tvPhoneNumber.text = currentContacts.phoneNumber
        holder.binding.tvEmailAdress.text = currentContacts.email
        holder.binding.tvAddress.text = currentContacts.address
        Picasso.get().load(currentContacts.image)
            .resize(300,300)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(holder.binding.ivContacts)
        var context = holder.itemView.context
        holder.binding.ivContacts.setOnClickListener{
           Toast.makeText(context,"You have clicked the image",Toast.LENGTH_SHORT).show()
        }
        holder.binding.cardview.setOnClickListener{
           val intent = Intent(context,ViewContactActivity::class.java)
            intent.putExtra("ADDRESS", currentContacts.address)
            intent.putExtra("NAME", currentContacts.name)
            intent.putExtra("EMAIL", currentContacts.email)
            intent.putExtra("PHONENUMBER", currentContacts.phoneNumber)
            intent.putExtra("IMAGE", currentContacts.image)


            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
     return contactsList.size
    }
}
class ContactViewHolder(val binding: ContactsListItemBinding): RecyclerView.ViewHolder(binding.root)

package com.example.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var contacts: MutableList<ItemContact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.name.text = contact.name
        holder.emailName.text = contact.emailName
        holder.phoneNumber.text = contact.phoneNumber
        holder.imageRemove.setOnClickListener {

            onDeleteClick.OnImageClicked(position, contact)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name_contact)
        val emailName: TextView = itemView.findViewById(R.id.name_email)
        val phoneNumber: TextView = itemView.findViewById(R.id.name_number)
        val imageRemove: ImageView = itemView.findViewById(R.id.image_remove)
    }


    fun interface OnImageRemoveListener {
        fun OnImageClicked(position: Int, contact: ItemContact)

    }

    lateinit var onDeleteClick: OnImageRemoveListener

    fun deleteContact(position: Int, contact: ItemContact) {
        contacts.remove(contact)
        notifyItemRemoved(position)
    }

    fun setContactList(list: MutableList<ItemContact>) {
        contacts = list
    }

    fun addContact(contact: ItemContact) {
        contacts.add(contact)
        notifyItemInserted(contacts.size - 1)
    }


}
package com.example.fintechapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fintechapp.Adapter.ContactsAdapter
import com.example.fintechapp.Adapter.TransferAdapter
import com.example.fintechapp.Model.Contacts
import com.example.fintechapp.Model.Transfer
import com.example.fintechapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var contactsAdapter: ContactsAdapter
    lateinit var transferAdapter: TransferAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactList= mutableListOf<Contacts>()
        contactList.add(Contacts(R.drawable.img2,"Tom"))
        contactList.add(Contacts(R.drawable.img2,"Sam"))
        contactList.add(Contacts(R.drawable.img2,"John"))
        contactList.add(Contacts(R.drawable.img2,"Kay"))
        contactList.add(Contacts(R.drawable.img2,"Michael"))
        binding.contactsRecyclerview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.contactsRecyclerview.setHasFixedSize(true)
        contactsAdapter=ContactsAdapter(this,contactList)
        binding.contactsRecyclerview.adapter=contactsAdapter

        //transfer adapter
        val transferList= mutableListOf<Transfer>()
        transferList.add(Transfer(R.drawable.people,"Transfer to contacts"))
        transferList.add(Transfer(R.drawable.window_dock,"Transfer card Number"))
        transferList.add(Transfer(R.drawable.people,"People"))
        transferList.add(Transfer(R.drawable.window_dock,"Transfer card Number"))



    }
}
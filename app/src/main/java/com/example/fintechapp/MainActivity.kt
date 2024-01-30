package com.example.fintechapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fintechapp.Adapter.ContactsAdapter
import com.example.fintechapp.Adapter.TransferAdapter
import com.example.fintechapp.Model.Contacts
import com.example.fintechapp.Model.Transfer
import com.example.fintechapp.databinding.ActivityMainBinding
import com.google.android.material.carousel.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.mig35.carousellayoutmanager.CenterScrollListener







class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var contactsAdapter: ContactsAdapter

        lateinit var transferAdapter: TransferAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.materialCardView.setOnClickListener {
            val intent=Intent(this,StaticsActivity::class.java)
            startActivity(intent)
        }

        //
        binding.addContacts.setOnClickListener {
            val intent= Intent(this,TransferActivity::class.java)
            startActivity(intent)
        }


        val contactList = mutableListOf<Contacts>()
        contactList.add(Contacts(R.drawable.img2, "Tom"))
        contactList.add(Contacts(R.drawable.img2, "Sam"))
        contactList.add(Contacts(R.drawable.img2, "John"))
        contactList.add(Contacts(R.drawable.img2, "Kay"))
        contactList.add(Contacts(R.drawable.img2, "Michael"))
       /* val carousalLayoutManager: com.mig35.carousellayoutmanager.CarouselLayoutManager =
            com.mig35.carousellayoutmanager.CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL)
*/
//        carousalLayoutManager.setPostLayoutListener(CarouselZoomPostLayoutListener())
        binding.contactsRecyclerview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
//       binding.contactsRecyclerview.layoutManager = carousalLayoutManager
        binding.contactsRecyclerview.setHasFixedSize(true)
        contactsAdapter = ContactsAdapter(this, contactList)
        binding.contactsRecyclerview.adapter = contactsAdapter
//        binding.contactsRecyclerview.addOnScrollListener(CenterScrollListener())

        //transfer adapter
        val transferList = mutableListOf<Transfer>()
        transferList.add(Transfer(R.drawable.people, "Transfer to contacts"))
        transferList.add(Transfer(R.drawable.window_dock, "Transfer card Number"))
        transferList.add(Transfer(R.drawable.people, "Transfer card Number"))
        transferList.add(Transfer(R.drawable.window_dock, "Transfer card Number"))
        binding.transferRecylerview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.transferRecylerview.setHasFixedSize(true)
        transferAdapter= TransferAdapter(this,transferList)
        binding.transferRecylerview.adapter=transferAdapter


    }
}
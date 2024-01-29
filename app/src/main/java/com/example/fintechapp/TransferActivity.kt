package com.example.fintechapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.fintechapp.Adapter.CarousalAdapter
import com.example.fintechapp.CustomSlider.SlideView
import com.example.fintechapp.Model.Contacts
import com.example.fintechapp.databinding.ActivityTransferBinding
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.mig35.carousellayoutmanager.CenterScrollListener

class TransferActivity : AppCompatActivity() {
    lateinit var binding: ActivityTransferBinding
    lateinit var carousalRecyclerView: RecyclerView
    lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransferBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //slideview
        binding.slideView.setOnSlideCompleteListener(object :SlideView.OnSlideCompleteListener{
            override fun onSlideComplete(slideView: SlideView?) {
                val buttonImageDisabled = ContextCompat.getDrawable(this@TransferActivity, R.drawable.sent)
                slideView?.setButtonImageDisabled(buttonImageDisabled)
                slideView?.isEnabled=false
            }

        })

        val contactList = mutableListOf<Contacts>()
        contactList.add(Contacts(R.drawable.img2, "Tom"))
        contactList.add(Contacts(R.drawable.img2, "Sam"))
        contactList.add(Contacts(R.drawable.img2, "John"))
        contactList.add(Contacts(R.drawable.img2, "Kay"))
        contactList.add(Contacts(R.drawable.img2, "Prabhat"))
        contactList.add(Contacts(R.drawable.img2, "Sonu"))
        contactList.add(Contacts(R.drawable.img2, "Tom"))
        contactList.add(Contacts(R.drawable.img2, "Ryan"))
        contactList.add(Contacts(R.drawable.img2, "Kagel"))
        contactList.add(Contacts(R.drawable.img2, "Ron"))
        contactList.add(Contacts(R.drawable.img2, "Kim"))
        contactList.add(Contacts(R.drawable.img2, "Masni"))
        contactList.add(Contacts(R.drawable.img2, "Akash"))
        setContentView(binding.root)
        carousalRecyclerView = binding.carouselRecyclerView
        val customCarousal=
            com.mig35.carousellayoutmanager.CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL)
        customCarousal.setPostLayoutListener(CarouselZoomPostLayoutListener())
       /* carousalRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)*/
        carousalRecyclerView.layoutManager=customCarousal

        carousalRecyclerView.adapter = CarousalAdapter(this, contactList)
        carousalRecyclerView.addOnScrollListener(CenterScrollListener())
        // Scroll RecyclerView to the middle position
        val middlePosition = contactList.size / 2
        carousalRecyclerView.scrollToPosition(middlePosition)


        //learning viewpager
       /* viewPager2 = binding.viewpager2
        viewPager2.adapter = ViewPagerAdapter(this, contactList)
        viewPager2.offscreenPageLimit = 7
        viewPager2.clipChildren = false
        viewPager2.clipToPadding = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val transformer: CompositePageTransformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(1))
        val customtransformer = ViewPager2.PageTransformer({ page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.1f
        })
        transformer.addTransformer(customtransformer)
        viewPager2.setPageTransformer(transformer)
        // Scroll ViewPager2 to the middle element
        viewPager2.post {
            val middlePosition = contactList.size / 2
            viewPager2.setCurrentItem(middlePosition, false)
        }*/


    }

    override fun onDestroy() {
        super.onDestroy()


    }
}
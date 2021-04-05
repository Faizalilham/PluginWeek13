package com.example.tugasweek13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.tugasweek13.Interface.komunikator
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*

class MainActivity : AppCompatActivity(),komunikator {
    lateinit var SecondFragment : SecondFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment(FirstFragment())

        val bottom = findViewById<BottomNavigationView>(R.id.btm)
        val frame = findViewById<FrameLayout>(R.id.framelayout)
      bottom.setOnNavigationItemSelectedListener { item ->
          when(item.itemId){
              R.id.create->{
                  SecondFragment = SecondFragment()
                  supportFragmentManager
                      .beginTransaction()
                      .replace(R.id.framelayout,SecondFragment)
                      .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                      .commit()
              }
              R.id.back->{
                finish()
              }
          }
          true
      }


    }
    private fun setFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.framelayout,fragment)
            .commit()
    }

    override fun setdata(Input: String) {
        val Bundel = Bundle()
        Bundel.putString("Nama",Input)

        val transaksi = this.supportFragmentManager.beginTransaction()
        val firstfragment = FirstFragment()
        firstfragment.arguments = Bundel
        transaksi.replace(R.id.framelayout,firstfragment)
        transaksi.commit()
    }

    override fun setdata2(Input2: String) {
        val Bundel = Bundle()
        Bundel.putString("Squad",Input2)
        val transaksi = this.supportFragmentManager.beginTransaction()
        val firstfragment = FirstFragment()
        firstfragment.arguments = Bundel
        transaksi.add(R.id.framelayout,firstfragment)
        transaksi.commit()

    }

    override fun setdata3(Input3: String) {
        val Bundel = Bundle()
        Bundel.putString("Angkatan",Input3)
        val transaksi = this.supportFragmentManager.beginTransaction()
        val firstfragment = FirstFragment()
        firstfragment.arguments = Bundel
        transaksi.add(R.id.framelayout,firstfragment)
        transaksi.commit()

    }

    override fun setdata4(Input4: String) {
        val Bundel = Bundle()
        Bundel.putString("Hobby",Input4)
        val transaksi = this.supportFragmentManager.beginTransaction()
        val firstfragment = FirstFragment()
        firstfragment.arguments = Bundel
        transaksi.add(R.id.framelayout,firstfragment)
        transaksi.commit()
    }


}
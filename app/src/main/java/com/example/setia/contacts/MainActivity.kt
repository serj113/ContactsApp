package com.example.setia.contacts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.setia.contacts.contactlist.ContactListFragment
import com.example.setia.contacts.contactlist.ContactListFragmentDirections
import com.example.setia.contacts.contactlist.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContactListFragment.OnListFragmentInteractionListener {

    private val navController by lazy {
        Navigation.findNavController(this, R.id.mainNavigationFragment)
    }
    override fun onSupportNavigateUp() =
        findNavController(R.id.mainNavigationFragment).navigateUp()

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        val action = ContactListFragmentDirections.openContactDetailFragment()
        navController.navigate(action)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}

package com.example.setia.contacts.contactdetail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.setia.contacts.R
import com.example.setia.contacts.base.BaseFragment

class ContactDetailFragment : BaseFragment() {

    private lateinit var viewModel: ContactDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contact_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ContactDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

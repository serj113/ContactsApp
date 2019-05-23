package com.example.setia.contacts.contactdetail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.setia.contacts.R
import com.example.setia.contacts.base.BaseFragment

class ContactDetailFragment : BaseFragment<ContactDetailViewModel>() {

    override fun initVM() {
        vm = ViewModelProviders.of(this).get(ContactDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contact_detail_fragment, container, false)
    }

}

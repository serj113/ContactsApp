package com.example.setia.contacts.createcontact

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.setia.contacts.R
import com.example.setia.contacts.base.BaseFragment

class CreateContactFragment : BaseFragment<CreateContactViewModel>() {

    companion object {
        fun newInstance() = CreateContactFragment()
    }

    private lateinit var viewModel: CreateContactViewModel

    override fun initVM() {
        vm = ViewModelProviders.of(this).get(CreateContactViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_contact_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateContactViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

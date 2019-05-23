package com.example.setia.contacts.contactlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.setia.contacts.R
import com.example.setia.contacts.base.BaseFragment

import com.example.setia.contacts.model.Contact
import kotlinx.android.synthetic.main.fragment_contact_list.*

class ContactListFragment : BaseFragment<ContactListViewModel>() {

    private var listener: OnListFragmentInteractionListener? = null

    override fun initVM() {
        vm = ViewModelProviders.of(this).get(ContactListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Tada"
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.layoutManager = LinearLayoutManager(context)
        val adapter = MyContactListRecyclerViewAdapter(listener)
        vm?.getContactList()?.observe(this, Observer {
            it?.let(adapter::updateData)
        })

        list.adapter = adapter
        vm?.loadData()

        fab_create_contact.setOnClickListener {
            Navigation.findNavController(view).navigate(ContactListFragmentDirections.openCrateContactFragment())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Contact?)
    }
}

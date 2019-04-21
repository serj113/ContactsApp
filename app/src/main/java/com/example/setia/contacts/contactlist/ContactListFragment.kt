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

class ContactListFragment : BaseFragment() {

    private var listener: OnListFragmentInteractionListener? = null
    private val viewModel: ContactListViewModel by lazy {
        ViewModelProviders.of(this).get(ContactListViewModel::class.java)
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
        viewModel.getContactList().observe(this, Observer {
            it?.let {contactList ->
                adapter.updateData(contactList)
            }
        })

        list.adapter = adapter
        viewModel.loadData()

        fab_create_contact.setOnClickListener {
            Navigation.findNavController(view).navigate(ContactListFragmentDirections.openCrateContactFragment())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
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

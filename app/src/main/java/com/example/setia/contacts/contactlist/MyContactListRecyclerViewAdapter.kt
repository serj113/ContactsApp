package com.example.setia.contacts.contactlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.setia.contacts.R


import com.example.setia.contacts.contactlist.ContactListFragment.OnListFragmentInteractionListener
import com.example.setia.contacts.contactlist.dummy.DummyContent.DummyItem
import com.example.setia.contacts.model.Contact

import kotlinx.android.synthetic.main.fragment_contact_list_item.view.*

class MyContactListRecyclerViewAdapter(
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyContactListRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private var mValues: List<Contact> = listOf()

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Contact
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_contact_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.bind(item)

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    fun updateData(contactList: List<Contact>) {
        mValues = contactList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        private val viewModel = ContactViewModel()

        fun bind(contact: Contact) {
            viewModel.bind(contact)
        }

    }
}

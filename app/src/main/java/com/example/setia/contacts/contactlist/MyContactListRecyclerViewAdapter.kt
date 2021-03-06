package com.example.setia.contacts.contactlist

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.setia.contacts.R
import com.example.setia.contacts.contactlist.ContactListFragment.OnListFragmentInteractionListener
import com.example.setia.contacts.databinding.FragmentContactListItemBinding
import com.example.setia.contacts.model.Contact


class MyContactListRecyclerViewAdapter(
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyContactListRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private var mValues: List<Contact> = listOf()

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item: Contact? = v.tag as? Contact
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: FragmentContactListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.fragment_contact_list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.bind(item)
        holder.itemView.setOnClickListener(mOnClickListener)
    }

    override fun getItemCount(): Int = mValues.size

    fun updateData(contactList: List<Contact>) {
        mValues = contactList
        Log.d("tada", "asik ${contactList.size}")
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: FragmentContactListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = ContactViewModel()

        fun bind(contact: Contact) {
            viewModel.bind(contact)
            binding.viewModel = viewModel
        }

    }
}

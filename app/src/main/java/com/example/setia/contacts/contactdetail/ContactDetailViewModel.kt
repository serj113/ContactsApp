package com.example.setia.contacts.contactdetail

import android.app.Application
import com.example.setia.contacts.App
import com.example.setia.contacts.base.BaseAction
import com.example.setia.contacts.base.BaseVM

class ContactDetailViewModel(app: Application) : BaseVM<ContactDetailAction>(app) {

    override fun initActions() {
        actions = ContactDetailAction()
        if (actions is BaseAction) {
            getApplication<App>().getInjector().inject(actions!!)
        }
    }

}

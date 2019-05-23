package com.example.setia.contacts.createcontact

import android.app.Application
import com.example.setia.contacts.App
import com.example.setia.contacts.base.BaseAction
import com.example.setia.contacts.base.BaseVM

class CreateContactViewModel(app: Application) : BaseVM<CreateContactAction>(app) {

    override fun initActions() {
        actions = CreateContactAction()
        if (actions is BaseAction) {
            (getApplication<Application>() as? App)?.getInjector()?.inject(actions!!)
        }
    }

}

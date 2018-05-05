package archilyph.com.company.singleton

import android.app.Application
import archilyph.com.company.activity.MainActivity
import archilyph.com.company.database.CompanyRoomInstance
import archilyph.com.company.repository.EmployeeRepository
import archilyph.com.company.view_model.MainActivityViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext


val koinModule : Module = applicationContext {
    viewModel { MainActivityViewModel(get()) }
    factory { CompanyRoomInstance(get()) }
    factory { EmployeeRepository(get()) }
}

class CompanyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(koinModule))
    }
}
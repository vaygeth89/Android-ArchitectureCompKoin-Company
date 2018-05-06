package archilyph.com.company.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "employees")
data class Employee(@PrimaryKey(autoGenerate = true)
                    var id: Int?, val name: String, var age: Int)
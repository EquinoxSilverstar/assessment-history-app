package com.example.understand

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

fun main() {
    class MainActivity : AppCompatActivity() {
         // mapOf holds the data in the form of pairs which consists of keys and valuables, creating lists of pairs to link into textview with declared val ages
        private val historicalFigures = mapOf(
            40 to "Jesus Christ; he died for our sins and is son of God,he created christianity",
            67 to "Leonardo da Vinci; he was a italian polymath of the High Renaissance who was a active painter" +
                    " ,draughtsman and many more",
            30 to "Patsy Cline;she was a American singer whose talent and wide-ranging appeal made her one of the" +
                    " classic performers of the genre",
            43 to "Lucky Dube;he was a South African reggae musician,like Bob Marley, he was one of the best reggae artists,singing about social problems.",
            92 to "Albertina Sisulu; she was a political activist and also high profile of anti-apartheid resistance in South Africa",
            32 to "Bruce Lee; was a American born film actor who renowned for martial arts prowess and martial arts movies popular",
            76 to "Albert Einstein; he was a German Theoretical physicist who won Nobel Prize for Physics in 1921 and the most influential physicist",
            58 to "Andy Warhol; was a American visual artist and film director ,also a leading exponent of the Pop art movement",
            28 to " Heath Ledger; he was a Australian actor, known for his moving and amazing performances in diverses roles and awarded an Oscar for his " +
                    "role as the JOKER in Dark Knight in 2008",
            100 to "George Burns he was an American comedian and was known as part of a popular comedy",
        )
         // occurring switch statement
        private fun
                gethistoricalFigure(age: Int): String? {
            return historicalFigures[age]

        }
         // this will verify if val age is true or false until the switch statements identifies the valid or invalid val age
        fun isValidAge(ageString: String): Boolean {
            val age = ageString.toIntOrNull()
            return age != null && age in 20..100
            if (age == null) {
                return false
            } else if (age < 20 || age > 100) {
                return false
            }
            return true
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            // the format to link each val to the other to form input process and output
            val EditAge = findViewById<EditText>(R.id.EditAge)
            val button1 = findViewById<Button>(R.id.Button1)
            val button2 = findViewById<Button>(R.id.clearButton)
            val TextView = findViewById<TextView>(R.id.EditTextView)
            // getting the button using id we set on the user interface to function the specifications
            button1.setOnClickListener {
                val enterAge = EditAge.text.toString().trim()
                if (isValidAge(enterAge)) {
                    val age = enterAge.toInt()
                    val historicalFigure = gethistoricalFigure(age)
                    if (historicalFigure != null) {
                         // the valid output statement becomes true when the conditions are met
                        TextView.text =
                            "You are the same age as $historicalFigure ever since they passed away at age $age. "
                        // a invalid output statement becomes false with the val age below or above range 20 to 100
                    } else {
                        TextView.text =
                            "There isn't a famous figure in this list that passed away at the age of $age."
                    } // a alternative invalid output if the valuables do not match valid input declared
                } else {
                    TextView.text =
                        "Invalid input entered, try again my friend.Please enter a whole number between 20 and 100."
                }
                // clear button to reset process to run again
                button2.setOnClickListener {
                    EditAge.text.clear()
                    TextView.text =
                        " Enter your age above and click Generate history to see the results"
                }
            }
        }
    }

}

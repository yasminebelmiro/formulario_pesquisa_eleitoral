package ifgoiano.urt.formulario_pesquisa_eleitoral

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nome = findViewById<EditText>(R.id.etNome)
        val tituloEleitor = findViewById<EditText>(R.id.etTituloEleitor)
        val zona = findViewById<EditText>(R.id.etZona)
        val secao = findViewById<EditText>(R.id.etSecao)
        val cidade = findViewById<EditText>(R.id.etCidade)
        val estado = findViewById<Spinner>(R.id.spnEstado)
        val rgPrefeito = findViewById<RadioGroup>(R.id.rgPrefeito)
        val rgVerador = findViewById<RadioGroup>(R.id.rgVerador)

        val partido1 = findViewById<CheckBox>(R.id.cbPartido1)
        val partido2 = findViewById<CheckBox>(R.id.cbPartido2)
        val partido3 = findViewById<CheckBox>(R.id.cbPartido3)
        val partido4 = findViewById<CheckBox>(R.id.cbPartido4)
        val partido5 = findViewById<CheckBox>(R.id.cbPartido5)
        val partido6 = findViewById<CheckBox>(R.id.cbPartido6)

        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        btnEnviar.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java)

            // Pegando os dados dos inputs
            val dados = Bundle().apply {
                putString("nome", nome.text.toString())
                putString("titulo", tituloEleitor.text.toString())
                putString("zona", zona.text.toString())
                putString("secao", secao.text.toString())
                putString("cidade", cidade.text.toString())
                putString("estado", estado.selectedItem.toString())
                putString("prefeito", findViewById<RadioButton>(rgPrefeito.checkedRadioButtonId).text.toString())
                putString("verador", findViewById<RadioButton>(rgVerador.checkedRadioButtonId).text.toString())

                // Verificar partidos favoritos
                val partidos = mutableListOf<String>()
                if (partido1.isChecked) partidos.add(partido1.text.toString())
                if (partido2.isChecked) partidos.add(partido2.text.toString())
                if (partido3.isChecked) partidos.add(partido3.text.toString())
                if (partido4.isChecked) partidos.add(partido4.text.toString())
                if (partido5.isChecked) partidos.add(partido5.text.toString())
                if (partido6.isChecked) partidos.add(partido6.text.toString())
                // Adicione as demais CheckBoxes aqui...
                putStringArrayList("partidos", ArrayList(partidos))
            }

            intent.putExtras(dados)
            startActivity(intent)
        }
    }
}

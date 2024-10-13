package ifgoiano.urt.formulario_pesquisa_eleitoral

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvDados = findViewById<TextView>(R.id.tvDados)

        // Recuperando os dados do intent
        val nome = intent.getStringExtra("nome")
        val titulo = intent.getStringExtra("titulo")
        val zona = intent.getStringExtra("zona")
        val secao = intent.getStringExtra("secao")
        val cidade = intent.getStringExtra("cidade")
        val estado = intent.getStringExtra("estado")
        val prefeito = intent.getStringExtra("prefeito")
        val verador = intent.getStringExtra("verador")
        val partidos = intent.getStringArrayListExtra("partidos")

        // Exibindo os dados
        tvDados.text = """
            Nome: $nome
            Título de Eleitor: $titulo
            Zona: $zona
            Seção: $secao
            Cidade: $cidade
            Estado: $estado
            Prefeito: $prefeito
            Verador: $verador
            Partidos Favoritos: ${partidos?.joinToString(", ")}
        """.trimIndent()
    }
}
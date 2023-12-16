import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.RequiresExtension
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.logical.countries.R
import com.logical.countries.adapter.CountriesAdapter
import com.logical.countries.databinding.ActivityMainBinding
import com.logical.countries.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var countriesAdapter: CountriesAdapter

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.countriesRecyclerView.layoutManager = LinearLayoutManager(this)
        countriesAdapter = CountriesAdapter(emptyList()) // Initialize with empty list
        binding.countriesRecyclerView.adapter = countriesAdapter // Set the adapter
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun observeViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.viewState.collect { state ->
                binding.progressBar.visibility =
                    if (state.isDataLoading) View.VISIBLE else View.GONE
                binding.countriesRecyclerView.visibility =
                    if (!state.isDataLoading && state.countries.isNotEmpty()) View.VISIBLE else View.GONE
                binding.errorMessageTextView.visibility =
                    if (state.errorMessage.isNotEmpty()) View.VISIBLE else View.GONE
                binding.errorMessageTextView.text = state.errorMessage

                if (!state.isDataLoading && state.countries.isNotEmpty()) {
                    countriesAdapter = CountriesAdapter(state.countries)
                    binding.countriesRecyclerView.adapter = countriesAdapter
                }
            }
        }
    }
}

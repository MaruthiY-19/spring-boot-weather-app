document.addEventListener('DOMContentLoaded', function() {
    // Now, select the button by its correct ID: 'searchButton'
    const searchButton = document.getElementById('searchButton');
    const cityInput = document.getElementById('cityInput');
    const weatherResultDiv = document.getElementById('weatherResult');
    const errorMessageDiv = document.getElementById('errorMessage');

    // Check if all elements were found. If any is null, log an error to help debug HTML IDs.
    if (!searchButton) {
        console.error("Error: Element with ID 'searchButton' not found in HTML.");
        errorMessageDiv.innerHTML = '<p class="error-message">Initialization Error: Search button not found.</p>';
        return; // Stop execution if critical element is missing
    }
    if (!cityInput) {
        console.error("Error: Element with ID 'cityInput' not found in HTML.");
        errorMessageDiv.innerHTML = '<p class="error-message">Initialization Error: City input not found.</p>';
        return;
    }
    if (!weatherResultDiv) {
        console.error("Error: Element with ID 'weatherResult' not found in HTML.");
        errorMessageDiv.innerHTML = '<p class="error-message">Initialization Error: Weather result display area not found.</p>';
        return;
    }
    if (!errorMessageDiv) {
        console.error("Error: Element with ID 'errorMessage' not found in HTML.");
        // Can't display error to user here if div is missing, so just console log
        return;
    }

    // Attach the event listener to the 'searchButton' for a 'click' event
    searchButton.addEventListener('click', function(e) {
        e.preventDefault(); // Prevent default button behavior (like form submission if it was inside a form implicitly)

        const city = cityInput.value.trim();

        // Clear previous results and errors
        weatherResultDiv.style.display = 'none'; // Hide results initially
        errorMessageDiv.innerHTML = ''; // Clear error message

        if (city) {
            // Correct fetch call using template literal
            fetch(`/api/weather?city=${encodeURIComponent(city)}`)
                .then(response => {
                    if (!response.ok) {
                        // Handle HTTP errors (e.g., 400, 404, 500)
                        return response.text().then(text => {
                            let errorMessage = `Error: ${response.status}`;
                            try {
                                const errorJson = JSON.parse(text);
                                if (errorJson.message) {
                                    errorMessage += `: ${errorJson.message}`;
                                }
                            } catch (e) {
                                errorMessage += `: ${text}`; // Fallback to raw text if not JSON
                            }
                            throw new Error(errorMessage);
                        });
                    }
                    return response.json();
                })
                .then(data => {
                    // Display weather data
                    if (data && data.name) {
                        let weatherDescription = data.weather && data.weather.length > 0 ? data.weather[0].description : 'N/A';
                        let temperature = data.main ? data.main.temp : 'N/A';
                        let humidity = data.main ? data.main.humidity : 'N/A';
                        let windSpeed = data.wind ? data.wind.speed : 'N/A';
                        let country = data.sys ? data.sys.country : 'N/A';
                        let iconCode = data.weather && data.weather.length > 0 ? data.weather[0].icon : '';
                        let iconUrl = iconCode ? `http://openweathermap.org/img/wn/${iconCode}.png` : '';

                        // Update individual elements
                        document.getElementById('cityName').textContent = `${data.name}, ${country}`;
                        document.getElementById('description').textContent = `${weatherDescription}`;
                        document.getElementById('temperature').textContent = `Temperature: ${temperature} °C`;
                        document.getElementById('humidity').textContent = `Humidity: ${humidity}%`;
                        document.getElementById('windSpeed').textContent = `Wind Speed: ${windSpeed} m/s`;

                        // Add or update the weather icon dynamically
                        let iconElement = document.getElementById('weatherIcon');
                        if (!iconElement) {
                            iconElement = document.createElement('img');
                            iconElement.id = 'weatherIcon';
                            // Insert the icon after description or before temperature, adjust as needed
                            document.getElementById('description').after(iconElement);
                        }
                        iconElement.src = iconUrl;
                        iconElement.alt = "Weather icon";
                        iconElement.style.display = iconCode ? 'inline-block' : 'none'; // Show/hide based on iconUrl

                        weatherResultDiv.style.display = 'block'; // Show the results div
                    } else {
                        errorMessageDiv.innerHTML = `<p class="error-message">City not found or no data available.</p>`; // Use error message div
                        weatherResultDiv.style.display = 'none'; // Ensure results are hidden
                    }
                })
                .catch(error => {
                    errorMessageDiv.innerHTML = `<p class="error-message">Error: ${error.message}</p>`; // Use error message div
                    weatherResultDiv.style.display = 'none'; // Ensure results are hidden
                    console.error('Fetch error:', error);
                });
        } else {
            errorMessageDiv.innerHTML = `<p class="error-message">Please enter a city name.</p>`; // Use error message div
            weatherResultDiv.style.display = 'none'; // Ensure results are hidden
        }
    });
});
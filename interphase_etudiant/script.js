document.getElementById('searchForm').addEventListener('submit', function(e) {
    e.preventDefault();  // Empêcher le rechargement de la page

    // Récupérer le terme de recherche
    const searchTerm = document.querySelector('.search-input').value;
    
    // Vérifier si le terme de recherche est vide
    if (!searchTerm) {
        alert('Please enter a search term!');
        return;
    }

    // Effectuer une requête AJAX pour obtenir les résultats de la recherche
    fetch(`/api/search?term=${searchTerm}`)
        .then(response => response.json())
        .then(data => {
            if (data.length === 0) {
                alert('No results found.');
            } else {
                console.log('Results:', data);
                // Traiter les résultats ici, afficher une liste dynamique, etc.
            }
        })
        .catch(error => console.error('Error:', error));
});

const container = document.querySelector('.container');
const registerBtn = document.querySelector('.register-btn');
const loginBtn = document.querySelector('.login-btn');

registerBtn.addEventListener('click', () => {
    container.classList.add('active');
})

loginBtn.addEventListener('click', () => {
    container.classList.remove('active');
})

document.querySelector('.register-btn').addEventListener('click', () => {
    const container = document.querySelector('.container');
    container.classList.toggle('expanded'); 
});

document.querySelector('.login-btn').addEventListener('click', () => {
    const container = document.querySelector('.container');
    container.classList.remove('expanded'); 
});

function toggleUserInfo() {
    const modal = document.getElementById('user-info-modal');
    modal.classList.toggle('active');
}

function toggleFilterModal() {
    const filterModal = document.getElementById('filter-modal');
    filterModal.classList.toggle('active');
}

function resetFiltersOrSearch() {
    event.preventDefault();
    window.location.href = '/FIALKA_war/product';
}

function openUserProfile() {
    document.getElementById('userModal').style.display = 'block';
}

function closeUserProfile() {
    document.getElementById('userModal').style.display = 'none';
}

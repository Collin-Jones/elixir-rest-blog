export default function Navbar(props) {
    return `
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav"></div>
            
            <a class="navbar-brand"href="/posts" data-link>Posts</a>
            <a class="navbar-brand" href="/about" data-link>About</a>
            <a class="navbar-brand" href="/login" data-link>Login</a>
            <a class="navbar-brand" href="/register" data-link>Register</a>
            <a class="navbar-brand" href="/profile" data-link>Profile</a>
            <a class="navbar-brand" href="/logout" data-link>Logout</a>
            </div>
            </div>
            </div>
        </nav>
       
    `;
}
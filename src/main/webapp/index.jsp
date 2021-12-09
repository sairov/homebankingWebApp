<%@include file="./views/partials/header.jsp" %>
<h1 class="text-center m-5">Login</h1>
<main class="container d-flex justify-content-center align-items-center" >
    <form method="POST" action="/user/login" class="bg-light p-5 rounded">
        <div class="mb-3">
            <label for="user" class="form-label">Usuario</label>
            <input type="text" class="form-control" id="user" name="user" >
            <div id="userHelp" class="form-text">Nunca compartiremos sus datos con alguien más.</div>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="row align-items-center justify-content-between">
            <div class="col-auto">
                <button type="submit" class="btn btn-dark">Ingresar</button>
            </div>
            <div class="col-auto">
                <a href="./views/register" class="link-primary">Registrarme</a>
            </div>
        </div>
    </form>
</main>
<%@include file="./views/partials/footer.html" %>



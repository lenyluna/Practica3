<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Post - ${articulo.titulo}</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/css/blog-post.css" rel="stylesheet">
    <link href="/css/myCSS.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>

            </button>
            <p style="color: white;  padding-top: 15px; font-size: medium;">ULTRA BLOG</p>
        </div>


        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/">Home</a>
                </li>
            <#if login == "true">
                <li>
                    <a href="/CrearArticulo/${username}" >Nuevo Art&iacuteculo</a>
                </li>
            </#if>
            <#if login =="false">
                <li>
                    <a onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Log in</a>
                    <div id="id01" class="modal">
                        <form class="modal-content animate" method="post" action="/login/${articulo.id}">
                            <div class="imgcontainer">
                                <span onclick="document.getElementById('id01').style.display='none'" class="close"
                                      title="Close Modal">&times;</span>
                                <img src="/img/img_avatar2.png" alt="Avatar" class="avatar">
                            </div>
                            <div class="container2">
                                <label><span class="glyphicon glyphicon-user"></span><b> Username:</b></label>
                                <input type="text" name="username" required/>

                                <label><span class="glyphicon glyphicon-eye-open"></span><b> Password:</b></label>
                                <input type="password" name="password" required/>

                            </div>
                            <div class="container2" style="background-color:#f1f1f1">
                                <p align="center">
                                    <button type="submit" class="btn btn-primary"><span
                                            class="glyphicon glyphicon-off"></span> Log In
                                    </button>
                                    <button type="button" onclick="document.getElementById('id01').style.display='none'"
                                            class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>
                                        Cancel
                                    </button>
                                </p>
                            </div>
                        </form>
                    </div>
                </li>
                <li>
                    <a onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Sign up</a>
                    <div id="id02" class="modal">

                        <form class="modal-content animate" method="post" action="/signup/">
                            <span onclick="document.getElementById('id02').style.display='none'" class="close"
                                  title="Close Modal">&times;</span>
                            <div class="container2">
                                <label><b>Name:</b> </label>
                                <input type="text" name="nombre" required/>
                                <label><span class="glyphicon glyphicon-user"></span><b> Username: </b></label>
                                <input type="text" name="username" required/>
                                <label><span class="glyphicon glyphicon-eye-open"></span><b> Password: </b></label>
                                <input type="password" name="password" required/>
                                <label><b>¿Es un usuario Admin?</b></label>
                                <input type="checkbox" name="administrador">
                                <label><b>¿Es un usuario autor?</b></label>
                                <input type="checkbox" name="autor">

                            </div>
                            <div class="container2" style="background-color:#f1f1f1">
                                <p align="center">
                                    <button type="submit" class="btn btn-primary"><span
                                            class="glyphicon glyphicon-send"></span> Send
                                    </button>
                                    <button type="button" onclick="document.getElementById('id02').style.display='none'"
                                            class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>
                                        Cancel
                                    </button>
                                </p>
                            </div>
                        </form>

                    </div>
                </li>
            </#if>
            <#if login == "true">
                <li >
                    <p style="color: white; padding-top: 15px; padding-left: 500px" >WELCOME ${username},<b><a href="/logout" style="color: white;"> log out</a> </b></p>

                </li>
            </#if>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Blog Post Content Column -->
        <div class="col-lg-8">

            <!-- Blog Post -->

            <!-- Title -->
            <h1> ${articulo.titulo}</h1>

            <!-- Author -->
            <p class="lead">
                by <a href="#">${articulo.autor}</a>
            </p>

            <hr>

            <!-- Date/Time -->
            <p><span class="glyphicon glyphicon-time"></span> Posted on ${articulo.fecha}</p>

            <hr>

            <!-- Post Content -->
            <p class="lead">${articulo.cuerpo}</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut, tenetur natus doloremque laborum quos iste ipsum rerum obcaecati impedit odit illo dolorum ab tempora nihil dicta earum fugiat. Temporibus, voluptatibus.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos, doloribus, dolorem iusto blanditiis unde eius illum consequuntur neque dicta incidunt ullam ea hic porro optio ratione repellat perspiciatis. Enim, iure!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error, nostrum, aliquid, animi, ut quas placeat totam sunt tempora commodi nihil ullam alias modi dicta saepe minima ab quo voluptatem obcaecati?</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum, dolor quis. Sunt, ut, explicabo, aliquam tenetur ratione tempore quidem voluptates cupiditate voluptas illo saepe quaerat numquam recusandae? Qui, necessitatibus, est!</p>

            <hr>

            <!-- Blog Comments -->

            <!-- Comments Form -->
            <div class="well">
                <h4>Comentarios:</h4>
                <form role="form">
                    <div class="form-group">
                        <textarea class="form-control" rows="3"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>

            <hr>

            <!-- Posted Comments -->

            <!-- Comment -->
            <div class="media">
                <a class="pull-left" href="#">
                    <img class="media-object" src="http://placehold.it/64x64" alt="">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">Start Bootstrap
                        <small>August 25, 2014 at 9:30 PM</small>
                    </h4>
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                </div>
            </div>

            <!-- Comment -->
            <div class="media">
                <a class="pull-left" href="#">
                    <img class="media-object" src="http://placehold.it/64x64" alt="">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">Start Bootstrap
                        <small>August 25, 2014 at 9:30 PM</small>
                    </h4>
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                    <!-- Nested Comment -->
                    <div class="media">
                        <a class="pull-left" href="#">
                            <img class="media-object" src="http://placehold.it/64x64" alt="">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">Nested Start Bootstrap
                                <small>August 25, 2014 at 9:30 PM</small>
                            </h4>
                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                        </div>
                    </div>
                    <!-- End Nested Comment -->
                </div>
            </div>

        </div>

        <!-- Blog Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Blog Categories Well -->
            <div class="well">
                <h4>Etiquetas del art&iacuteculo:</h4>
                <div class="row">
                    <div class="col-lg-6">
                        <ul class="list-unstyled">
                        <#list listEti as etiqueta>
                            <li><a href="#"> ${etiqueta.etiqueta}</a>
                            </li>
                        </#list>
                        </ul>
                    </div>
                </div>
                <!-- /.row -->
            </div>
        </div>

    </div>
    <!-- /.row -->

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12" align="center">
                <p>Copyright &copy;</p>
            </div>
        </div>
        <!-- /.row -->
    </footer>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="js/jquery.js"></script>
<script src="/js/myJquery.js"></script>

</body>

</html>

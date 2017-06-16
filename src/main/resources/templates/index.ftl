<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Luna's Blog Home</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/css/blog-home.css" rel="stylesheet">
    <link href="/css/myCSS.css" rel="stylesheet">
</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
           <p style="color: white;  padding-top: 15px; font-size: medium;">Luna's blog</p>
        </div>



        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/index">Home</a>
                </li>
                <li>
                    <a href="/nuevoArticulo">Nuevo Art&iacuteculo</a>
                </li>
                <li>
                    <a onclick="document.getElementById('id01').style.display='block'" style="width:auto;" >Log in</a>
                    <div id="id01" class="modal">
                        <form class="modal-content animate" action="">
                            <div class="imgcontainer">
                                <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                                <img src="/img/img_avatar2.png" alt="Avatar" class="avatar">
                            </div>
                            <div class="container2">
                                <label><span class="glyphicon glyphicon-user"></span><b> Username:</b></label>
                                <input type="text"  name="uname" required/>

                                <label><span class="glyphicon glyphicon-eye-open"></span><b> Password:</b></label>
                                <input type="password"  name="psw" required/>

                            </div>
                            <div class="container2" style="background-color:#f1f1f1">
                                <p align="center"><button type="submit" class="btn btn-primary" ><span class="glyphicon glyphicon-off"></span> Log In</button>
                                    <button type="button" onclick="document.getElementById('id01').style.display='none'" class="btn btn-danger" ><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                                </p>
                            </div>
                        </form>
                    </div>
                </li>
                <li>
                    <a onclick="document.getElementById('id02').style.display='block'" style="width:auto;" >Sign up</a>
                    <div id="id02" class="modal">

                        <form class="modal-content animate" action="">
                            <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
                            <div class="container2">
                                <label><b>Name:</b> </label>
                                <input type="text" name="nombre" required/>
                                <label><span class="glyphicon glyphicon-user"></span><b> Username: </b></label>
                                <input type="text" name="usuario" required/>
                                <label><span class="glyphicon glyphicon-eye-open"></span><b> Password: </b></label>
                                <input type="text" name="psw" required/>
                                <label><b>¿Es un usuario Admin?</b></label>
                                <input type="checkbox" name="admin">
                                <label><b>¿Es un usuario autor?</b></label>
                                <input type="checkbox" name="autor">

                            </div>
                            <div class="container2" style="background-color:#f1f1f1">
                                <p align="center"><button type="submit" class="btn btn-primary" ><span class="glyphicon glyphicon-send"></span> Send</button>
                                    <button type="button" onclick="document.getElementById('id02').style.display='none'" class="btn btn-danger" ><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                                </p>
                            </div>
                        </form>

                    </div>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container" >

    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="page-header">
                Page Heading
                <small>Secondary Text</small>
            </h1>

            <!-- First Blog Post -->
            <h2>
                <a href="#">Blog Post Title</a>
            </h2>
            <p class="lead">
                by <a href="index.php">Start Bootstrap</a>
            </p>
            <p><span class="glyphicon glyphicon-time"></span> Posted on August 28, 2013 at 10:00 PM</p>
            <hr>
            <img class="img-responsive" src="http://placehold.it/900x300" alt="">
            <hr>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore, veritatis, tempora, necessitatibus inventore nisi quam quia repellat ut tempore laborum possimus eum dicta id animi corrupti debitis ipsum officiis rerum.</p>
            <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>

            <hr>

            <!-- Second Blog Post -->
            <h2>
                <a href="#">Blog Post Title</a>
            </h2>
            <p class="lead">
                by <a href="index.php">Start Bootstrap</a>
            </p>
            <p><span class="glyphicon glyphicon-time"></span> Posted on August 28, 2013 at 10:45 PM</p>
            <hr>
            <img class="img-responsive" src="http://placehold.it/900x300" alt="">
            <hr>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quibusdam, quasi, fugiat, asperiores harum voluptatum tenetur a possimus nesciunt quod accusamus saepe tempora ipsam distinctio minima dolorum perferendis labore impedit voluptates!</p>
            <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>

            <hr>

            <!-- Third Blog Post -->
            <h2>
                <a href="#">Blog Post Title</a>
            </h2>
            <p class="lead">
                by <a href="index.php">Start Bootstrap</a>
            </p>
            <p><span class="glyphicon glyphicon-time"></span> Posted on August 28, 2013 at 10:45 PM</p>
            <hr>
            <img class="img-responsive" src="http://placehold.it/900x300" alt="">
            <hr>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cupiditate, voluptates, voluptas dolore ipsam cumque quam veniam accusantium laudantium adipisci architecto itaque dicta aperiam maiores provident id incidunt autem. Magni, ratione.</p>
            <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>

            <hr>

            <!-- Pager -->
            <ul class="pager">
                <li class="previous">
                    <a href="#">&larr; Older</a>
                </li>
                <li class="next">
                    <a href="#">Newer &rarr;</a>
                </li>
            </ul>

        </div>

        <!-- Blog Sidebar Widgets Column -->
        <div class="col-md-4" style="margin-top: 50px ;>


            <!-- Side Widget Well -->
            <div class="well" >
                <h4>Side Widget Well</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore, perspiciatis adipisci accusamus laudantium odit aliquam repellat tempore quos aspernatur vero.</p>
            </div>

        </div>

    </div>
    <!-- /.row -->

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row" align="center">
            <div class="col-lg-12">
                <p>Copyright &copy; Your Website 2014</p>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </footer>

</div>
<!-- jQuery-->
<script src="/js/jquery.js"></script>
<script src="/js/myJquery.js"></script>
</body>

</html>

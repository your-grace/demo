<!doctype html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://cdn.jsdelivr.cn/npm/@bootcss/v3.bootcss.com@1.0.54/favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/dashboard/">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">
	
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../static/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../static/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="https://cdn.jsdelivr.cn/npm/@bootcss/v3.bootcss.com@1.0.54/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="https://cdn.jsdelivr.cn/npm/@bootcss/v3.bootcss.com@1.0.54/assets/js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
<#--          <ul class="nav nav-sidebar">-->
<#--            <li><a href="">Nav item</a></li>-->
<#--            <li><a href="">Nav item again</a></li>-->
<#--            <li><a href="">One more nav</a></li>-->
<#--            <li><a href="">Another nav item</a></li>-->
<#--            <li><a href="">More navigation</a></li>-->
<#--          </ul>-->
<#--          <ul class="nav nav-sidebar">-->
<#--            <li><a href="">Nav item again</a></li>-->
<#--            <li><a href="">One more nav</a></li>-->
<#--            <li><a href="">Another nav item</a></li>-->
<#--          </ul>-->
<#--        </div>-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>

<#--          <div class="row placeholders">-->
<#--            <div class="col-xs-6 col-sm-3 placeholder">-->
<#--              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">-->
<#--              <h4>Label</h4>-->
<#--              <span class="text-muted">Something else</span>-->
<#--            </div>-->
<#--            <div class="col-xs-6 col-sm-3 placeholder">-->
<#--              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">-->
<#--              <h4>Label</h4>-->
<#--              <span class="text-muted">Something else</span>-->
<#--            </div>-->
<#--            <div class="col-xs-6 col-sm-3 placeholder">-->
<#--              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">-->
<#--              <h4>Label</h4>-->
<#--              <span class="text-muted">Something else</span>-->
<#--            </div>-->
<#--            <div class="col-xs-6 col-sm-3 placeholder">-->
<#--              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">-->
<#--              <h4>Label</h4>-->
<#--              <span class="text-muted">Something else</span>-->
<#--            </div>-->
          </div>

          <h2 class="sub-header">角色管理</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>角色编码</th>
                  <th>角色名</th>
                  <th>创建人</th>
                  <th>创建时间</th>
                  <th>更新人</th>
                  <th>更新时间</th>
                </tr>
              </thead>
              <tbody>
               <#if roles?? && (roles?size>0)>
                 <#list roles as role>
                <tr>
                  <td>${role.rolecode}</td>
                  <td>${role.rolename}</td>
                  <td>${role.createName}</td>
                  <td>${role.createDate}</td>
                  <td>${role.updateName}</td>
                  <td>${role.updateDate}</td>
                </tr>
                 </#list>
              </#if>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../static/js/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../static/js/jquery.min.js"><\/script>')</script>
    <script src="../static/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../static/js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../static/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>

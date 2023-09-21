<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>

<?php include($_SERVER['DOCUMENT_ROOT'].'/readlanguage.php');$idioma=readLanguage("es");?>
        <META content="3 days" name=Revisit>
        <META content=all name=robots>
        <META http-equiv=Content-Type content="text/html; charset=iso-8859-1">
        <link href="/css/normal.css" rel="stylesheet" type="text/css">
<title>
<?php if ($idioma=='es')
echo "Sickle Cell Disease Severity Calculator"; else echo "
Sickle Cell Disease Severity Calculator";
?>
</title></head>

<body>

<h1>
<?php if ($idioma=='es')
echo "Sickle Cell Disease Severity Calculator"; else echo "Sickle Cell Disease Severity Calculator";
?>
</h1>
<h3>Download the program</h3>
You first need to <a href="/dss-calculator/dist//dss-calculator.jar">download dss-calculator</a>.

<p>
This calculator has been written in Java. Make sure you hava java (jre) installed in your computer. You may run the calculator by following the next steps:
<h4>Run it from a text terminal (command prompt):</h4>
<ol>
<li> Open a text terminal</li>
<li> Move to the folder where you stored the file</li>
<li> Run it with the command "java -jar dss-calculator.java"</li>
</ol>

<h4>Run it from the graphical user interface:</h4> 
<ol>
<li>Right click on the jar file and choose to open with Java</li>
<li>If running is not allowed, follow the next steps:</li>
<ol>
<li>Right click on the jar file</li>
<li>Select Properties from the menu</li>
<li>Navigate to the permission tab</li>
<li>Check the box "Allow execution file as program"</li>
</ol>
</ol>



</body>

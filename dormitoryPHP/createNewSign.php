<?php
    include_once("connect.php");
    $Rtime=$_POST['Rtime'];//APP post过来的签到日期
    $houseparentID=$_POST['houseparentID'];//APP post过来的宿管号
    $title=$_POST['title'];//APP post过来的签到标题
    $result=mysqli_query($conn,"INSERT INTO signrecord (Rtime,houseparentID,title) VALUES('$Atime','$houseparentID','$title')");
     if($result){
       $back['status']="8";
       $back['info']="start a new sign success";
       echo (json_encode($back));
    }else{
       $back['status']="-11";
       $back['info']="start a new sign fail";
       echo (json_encode($back));
    }
    mysqli_close($conn);
 ?>
<?php
    include_once("connect.php");
    $Rtime=$_POST['Rtime'];//APP post������ǩ������
    $houseparentID=$_POST['houseparentID'];//APP post�������޹ܺ�
    $title=$_POST['title'];//APP post������ǩ������
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
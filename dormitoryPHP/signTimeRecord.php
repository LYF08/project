<?php
    include_once("connect.php");
    $SID=$_POST['SID'];//APP post过来的学生ID
    $recordID=(integer)$_POST['recordID'];//APP post过来的签到表编号
    $signedtime=$_POST['signedtime'];//APP post过来的签到时间
    $result=mysqli_query($conn,"INSERT INTO signed (SID,recordID,signedtime) VALUES('$SID',$recordID,'$signedtime')");
     if($result){
       $back['status']="9";
       $back['info']="sign success";
       echo (json_encode($back));
    }else{
       $back['status']="-12";
       $back['info']="sign fail";
       echo (json_encode($back));
    }
    mysqli_close($conn);
 ?>
set PACKAGE=back.cmm.module
set WORK_DIR_FULL_PATH=C:\Users\mw\pjts\backend\BackCmmModule\src\main\java\back\cmm\module
:: set WORK_DIR_FULL_PATH=C:\Users\mw\Desktop
@echo off
setlocal
chcp 65001 > nul

:conf
:: --------------------------------------------------------------------------------------------------------------
echo. input dir name (Example : projectMng)
set /p IPT_DIR_NM="dir name : "

echo. input table name (Example : projectMng)
set /p TB_NM="table name : "

echo. input url mapping (Example : project)
set /p URL_MAPPING="url mapping : "

echo. input tag name (Example : 프로젝트 - 프로젝트 관리 API)
set /p TAG_NM="tag name : "

:: --------------------------------------------------------------------------------------------------------------
for /f %%i in ('powershell -Command "[CultureInfo]::CurrentCulture.TextInfo.ToTitleCase('%IPT_DIR_NM%')"') do set PASCAL=%%i
for /f %%i in ('powershell -Command "[CultureInfo]::CurrentCulture.TextInfo.ToTitleCase('%IPT_DIR_NM%').Substring(0,1).ToLower() + '%IPT_DIR_NM%'.Substring(1)"') do set CAMEL=%%i

mkdir %WORK_DIR_FULL_PATH%\%CAMEL%
mkdir %WORK_DIR_FULL_PATH%\%CAMEL%\dao
mkdir %WORK_DIR_FULL_PATH%\%CAMEL%\dto
mkdir %WORK_DIR_FULL_PATH%\%CAMEL%\domain
mkdir %WORK_DIR_FULL_PATH%\%CAMEL%\service
mkdir %WORK_DIR_FULL_PATH%\%CAMEL%\web
goto run

:writeFile
:: --------------------------------------------------------------------------------------------------------------
set SRC_FILE_EXTN=txt
set TARGET_DIR_NM=%1
set TARGET_FILE_NM=%2

powershell -Command "(Get-Content builderConf/%TARGET_DIR_NM%/%TARGET_FILE_NM%.%SRC_FILE_EXTN%) -replace '@PACKAGE@', '%PACKAGE%' -replace '@PASCAL@', '%PASCAL%' -replace '@CAMEL@', '%CAMEL%' -replace '@TB_NM@', '%TB_NM%' -replace '@URL_MAPPING@', '%URL_MAPPING%' -replace '@TAG_NM@', '%TAG_NM%' | Set-Content %WORK_DIR_FULL_PATH%/%CAMEL%/%TARGET_DIR_NM%/%PASCAL%%TARGET_FILE_NM%.java" -Encoding utf8
echo. created at %WORK_DIR_FULL_PATH%/%CAMEL%/%TARGET_DIR_NM%/%PASCAL%%TARGET_FILE_NM%.java

:: powershell -Command "(Get-Content builderConf/%TARGET_DIR_NM%/%TARGET_FILE_NM%.%SRC_FILE_EXTN%) -replace '@PACKAGE@', '%PACKAGE%' | Set-Content %WORK_DIR_FULL_PATH%/%CAMEL%/%TARGET_DIR_NM%/%TARGET_FILE_NM%.java"
:: powershell -Command "(Get-Content builderConf/%TARGET_DIR_NM%/%TARGET_FILE_NM%.%SRC_FILE_EXTN%) -replace '@PASCAL@', '%PASCAL%' | Set-Content %WORK_DIR_FULL_PATH%/%CAMEL%/%TARGET_DIR_NM%/%TARGET_FILE_NM%.java"
:: powershell -Command "(Get-Content builderConf/%TARGET_DIR_NM%/%TARGET_FILE_NM%.%SRC_FILE_EXTN%) -replace '@CAMEL@', '%CAMEL%' | Set-Content %WORK_DIR_FULL_PATH%/%CAMEL%/%TARGET_DIR_NM%/%TARGET_FILE_NM%.java"
:: powershell -Command "(Get-Content builderConf/%TARGET_DIR_NM%/%TARGET_FILE_NM%.%SRC_FILE_EXTN%) -replace '@TB_NM@', '%TB_NM%' | Set-Content %WORK_DIR_FULL_PATH%/%CAMEL%/%TARGET_DIR_NM%/%TARGET_FILE_NM%.java"
:: powershell -Command "(Get-Content builderConf/%TARGET_DIR_NM%/%TARGET_FILE_NM%.%SRC_FILE_EXTN%) -replace '@URL_MAPPING@', '%URL_MAPPING%' | Set-Content %WORK_DIR_FULL_PATH%/%CAMEL%/%TARGET_DIR_NM%/%TARGET_FILE_NM%.java"
:: powershell -Command "(Get-Content builderConf/%TARGET_DIR_NM%/%TARGET_FILE_NM%.%SRC_FILE_EXTN%) -replace '@TAG_NM@', '%TAG_NM%' | Set-Content %WORK_DIR_FULL_PATH%/%CAMEL%/%TARGET_DIR_NM%/%TARGET_FILE_NM%.java"
goto :eof

:run
:: --------------------------------------------------------------------------------------------------------------
echo. -- DAO
call :writeFile dao Repository
call :writeFile dao RepositoryCustom
call :writeFile dao RepositoryCustomImpl

echo. -- DOMAIN
call :writeFile domain Bean

echo. -- DTO
echo. create dto package
call :writeFile dto Dto
call :writeFile dto FormDto
call :writeFile dto SearchDto

echo. -- SERVICE
echo. create service package
call :writeFile service Service
call :writeFile service ServiceImpl

echo. -- WEB
echo. create web package
call :writeFile web Api
echo. BUILD SUCCESS !

:end
:: --------------------------------------------------------------------------------------------------------------
endlocal
pause

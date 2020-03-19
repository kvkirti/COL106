# Enter timeout for unittests here
vpl_junit_timeout=60

# use the latest available version
vpl_junit_version=$(basename  $(ls vpl-junit*) .b64)

export CLASSPATH=$CLASSPATH:./$vpl_junit_version

# compile all .java files
javac -J-Xmx16m -Xlint:deprecation *.java

if [ "$?" -ne "0" ] ; then
  echo "Not compiled"
  exit 0
fi

timeout $vpl_junit_timeout java -jar $vpl_junit_version RunTest

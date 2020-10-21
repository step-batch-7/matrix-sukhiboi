./scripts/compile.sh
java -cp $(find lib -name '*.jar' | tr '\n' ':').:out org.junit.runner.JUnitCore com.step.sukhiboi.matrix.MatrixTest
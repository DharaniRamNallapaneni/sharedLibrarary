import com.i27.builds.Calc
//Constructor
Calc cal = new Calc(this)
pipeline {
    agent any
    stages {
        stage ('Add') {
            steps {
                script {
                  echo "Printing sum of 2 numbers"
                  println cal.add(3,4)
                }
            }
        }
        stage ('Multiply') {
            steps {
                script {
                  echo "Multiplying 2 numbers"
                  println cal.multiply(3,4)
                }
            }
        }
    }
}
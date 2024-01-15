import com.i27.builds.Calc

def call(Map pipelineParams){
    // this value is the one we given in jenkins
    library("com.i27.slb@main")
    //Constructor
    Calc cal = new Calc(this)
     pipeline {
      agent {
        label 'java-worker'
      }
      environment {
        // here this pipeline is expecting a value from service who ever is calling this pipeline
        APP_NAME = "${pipelineParams.appName}"
      }
       stages {
        stage ('Add') {
            steps {
                script {
                  echo "MicroService name is ${env.APP_NAME}"
                  echo "Printing sum of 2 numbers"
                  println cal.add(3,4)
                }
            }
        }
        stage ('Multiply') {
            steps {
                script {
                  echo "MicroService name is ${env.APP_NAME}"
                  echo "Multiplying 2 numbers"
                  println cal.multiply(3,4)
                }
            }
        }
    }
 }
}
#!/usr/bin/env groovy

def call(String DEV_MAIL_ID = 'er.dj1990@gmail.com') {
   emailext (
        subject: "FAILED: Job at STAGE ${env.STAGE_NAME} ${env.JOB_NAME} - ${env.BUILD_NUMBER}",
        attachLog: true, attachmentsPattern: '*.log',
        body: """<br><p><p>Check console output at &QUOT;<a href='${env.BUILD_URL}console'>${env.JOB_NAME} - ${env.BUILD_NUMBER}</a>&QUOT;</p><br>""",
        to: """${DEV_MAIL_ID}""", mimeType: 'text/html', recipientProviders: [[$class: 'DevelopersRecipientProvider']]
    )
}

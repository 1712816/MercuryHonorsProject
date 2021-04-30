import * as functions from "firebase-functions";
import * as admin from "firebase-admin";

const topic = "CMB_Updates";
const options ={
  priority: "HIGH",
};
let multiple = false;
admin.initializeApp();
/** @return {string} it returns & if multiple warnings have been issued */
export function ifMultiple() {
  if (multiple) {
    return "& ";
  } else {
    return "";
  }
}

export const newNotification = functions.firestore
    .document("updates/{emailID}")
    .onCreate((snapshot, context) => {
      const newValue = snapshot.data();
      const body = newValue.emailBody;
      const subject = newValue.emailSubject;
      let alertTitle = "";
      let alertBody = "";
      let colour ="";
      console.log(subject);
      if (!(subject.search(/Yellow/gi) == -1)) {
        alertTitle = "Yellow Warning For ";
        alertBody = "The MetOffice Has Issued a Yellow Warning For ";
        colour = "#FFD800";
      } else if (!(subject.search(/Amber/gi) == -1)) {
        alertTitle = "Amber Warning For ";
        alertBody = "The MetOffice Has Issued an Amber Warning For ";
        colour = "#FF8B00";
      } else if (!(subject.search(/Red/gi) == -1)) {
        alertTitle = "Red Warning For ";
        alertBody = "The MetOffice Has Issued a Red Warning For ";
        colour = "#FF0027";
      }
      if (!(subject.search(/Snow/gi) == -1)) {
        alertTitle = alertTitle + ifMultiple() + "SNOW ";
        alertBody = alertBody + ifMultiple() + "Snow ";
        if (multiple == false) {
          multiple = true;
        }
      }
      if (!(subject.search(/Ice/gi) == -1)) {
        alertTitle = alertTitle + ifMultiple() + "ICE ";
        alertBody = alertBody + ifMultiple() + "Ice ";
        if (multiple == false) {
          multiple = true;
        }
      }
      if (!(subject.search(/Wind/gi) == -1)) {
        alertTitle = alertTitle + ifMultiple() + "WIND ";
        alertBody = alertBody + ifMultiple() + "Wind ";
        if (multiple == false) {
          multiple = true;
        }
      }
      if (!(subject.search(/Fog/gi) == -1)) {
        alertTitle = alertTitle + ifMultiple() + "FOG ";
        alertBody = alertBody + ifMultiple() + "Fog ";
        if (multiple == false) {
          multiple = true;
        }
      }
      if (!(subject.search(/Rain/gi) == -1)) {
        alertTitle = alertTitle + ifMultiple() + "RAIN ";
        alertBody = alertBody + ifMultiple() + "Rain ";
        if (multiple == false) {
          multiple = true;
        }
      }
      alertBody = alertBody + "in the Area, What to Expect - ";
      const headline = body.split("Headline").pop();
      alertBody = alertBody + headline.split(".", 1)[0];
      const message = {
        notification: {
          title: alertTitle,
          body: alertBody,
        },
        android: {
          notification: {
            color: colour,
          },
        },
        topic: topic,
      };
      return admin.messaging().send(message);
    });

export const newTwitterNotification = functions.firestore
    .document("twitterupdates/{twitterID}")
    .onCreate((snapshot, context) => {
      const newValue = snapshot.data();
      const twitterMessage = newValue.tweet;
      // const twitterUser = newValue.user;
      const message = {
        notification: {
          title: "Police Scotland Report",
          body: twitterMessage,
        },
      };
      return admin.messaging().sendToTopic(topic, message, options);
    });

export const newSMSNotification = functions.firestore
    .document("smsupdates/{smsID}")
    .onCreate((snapshot, context) => {
      // const newValue = snapshot.data();
      // const smsMessage = newValue.smsMessage;
      // const smsFrom = newValue.from;
      const message = {
        notification: {
          title: "SEPA FLOOD ALERT",
          body: "SEPA has reported a flood alert "+
          "in the area, please see our reccommended"+
          " steps to follow within the app.",
        },
        android: {
          notification: {
            icon: "@drawable/appicon.png",
          },
        },
        topic: topic,
      };
      return admin.messaging().send(message);
    });

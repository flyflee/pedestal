(ns immutant.init
    (:require [immutant.web :as web]
              [io.pedestal.http :as bootstrap]
              [io.pedestal.log :as log]
              [jboss.service :as service]
              [jboss.server :as server]))

(let [servlet-map (bootstrap/create-servlet service/service)]
  (alter-var-root #'server/service-instance (constantly servlet-map))
  (def servlet (::bootstrap/servlet servlet-map))
)

(web/start-servlet "/" servlet)












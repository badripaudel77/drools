package com.app.tracker.utils;

import org.kie.api.event.process.*;
import org.kie.api.event.rule.*;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class related to listening events
 */
public class EventListenerUtil {

    private static Logger logger = LoggerFactory.getLogger(EventListenerUtil.class);

    public static void attachDefaultAgendaEventListener(KieSession kieSession) {
        // Attach event listeners to kieSession and check the triggered events

        // 1. Attaching DefaultAgendaEventListener
        kieSession.addEventListener(new DefaultAgendaEventListener() {
            @Override
            public void beforeMatchFired(BeforeMatchFiredEvent beforeMatchFiredEvent) {
                super.beforeMatchFired(beforeMatchFiredEvent);
                logger.info("EventListenerUtil <<<>>> DefaultAgendaEventListener >>>  BeforeMatchFiredEvent ::: Rule Name " + beforeMatchFiredEvent.getMatch().getRule().getName() + " fired.");
            }

            @Override
            public void afterMatchFired(AfterMatchFiredEvent afterMatchFiredEvent) {
                super.afterMatchFired(afterMatchFiredEvent);
                logger.info("EventListenerUtil <<<>>> DefaultAgendaEventListener >>>  AfterMatchFiredEvent ::: Rule Name " + afterMatchFiredEvent.getMatch().getRule().getName() + " fired.");
            }
        });
    }

    // 2. Attaching RuleRunTimeListener
    public static void attachRuleRunTimeListener(KieSession kieSession) {
        kieSession.addEventListener(new RuleRuntimeEventListener() {
            @Override
            public void objectInserted(ObjectInsertedEvent objectInsertedEvent) {
                logger.info("EventListenerUtil <<<>>> RuleRuntimeEventListener >>> " + objectInsertedEvent.getObject().getClass() + " inserted.");
            }

            @Override
            public void objectUpdated(ObjectUpdatedEvent objectUpdatedEvent) {
                logger.info("EventListenerUtil <<<>>> RuleRuntimeEventListener >>> " + objectUpdatedEvent.getObject().getClass() + " updated.");
            }

            @Override
            public void objectDeleted(ObjectDeletedEvent objectDeletedEvent) {
                logger.info("EventListenerUtil <<<>>>  RuleRuntimeEventListener >>> " + objectDeletedEvent.getOldObject().getClass() + " deleted.");
            }
        });
    }

    // 3. Attach ProcessEventListener
    public static void attachProcessEventListener(KieSession kieSession) {
        kieSession.addEventListener(new ProcessEventListener() {
            @Override
            public void beforeProcessStarted(ProcessStartedEvent processStartedEvent) {
                logger.info("EventListenerUtil <<<>>>  beforeProcessStarted >>> " + processStartedEvent.getEventDate());
            }

            @Override
            public void afterProcessStarted(ProcessStartedEvent processStartedEvent) {
                logger.info("EventListenerUtil <<<>>>  afterProcessStarted >>> " + processStartedEvent.getEventDate());
            }

            @Override
            public void beforeProcessCompleted(ProcessCompletedEvent processCompletedEvent) {
                logger.info("EventListenerUtil <<<>>>  beforeProcessCompleted >>> " + processCompletedEvent.getEventDate());
            }

            @Override
            public void afterProcessCompleted(ProcessCompletedEvent processCompletedEvent) {
                logger.info("EventListenerUtil <<<>>>  afterProcessCompleted >>> " + processCompletedEvent.getEventDate());
            }

            @Override
            public void beforeNodeTriggered(ProcessNodeTriggeredEvent processNodeTriggeredEvent) {
                logger.info("EventListenerUtil <<<>>>  beforeNodeTriggered >>> " + processNodeTriggeredEvent.getEventDate());
            }

            @Override
            public void afterNodeTriggered(ProcessNodeTriggeredEvent processNodeTriggeredEvent) {
                logger.info("EventListenerUtil <<<>>>  afterNodeTriggered >>> " + processNodeTriggeredEvent.getEventDate());
            }

            @Override
            public void beforeNodeLeft(ProcessNodeLeftEvent processNodeLeftEvent) {

            }

            @Override
            public void afterNodeLeft(ProcessNodeLeftEvent processNodeLeftEvent) {

            }

            @Override
            public void beforeVariableChanged(ProcessVariableChangedEvent processVariableChangedEvent) {
                logger.info("EventListenerUtil <<<>>>  beforeVariableChanged >>> " + processVariableChangedEvent.getEventDate());
            }

            @Override
            public void afterVariableChanged(ProcessVariableChangedEvent processVariableChangedEvent) {
                logger.info("EventListenerUtil <<<>>>  afterVariableChanged >>> " + processVariableChangedEvent.getEventDate());
            }
        });
    }
}

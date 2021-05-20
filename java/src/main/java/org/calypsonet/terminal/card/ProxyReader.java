/* **************************************************************************************
 * Copyright (c) 2018 Calypso Networks Association https://www.calypsonet-asso.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.calypsonet.terminal.card;

import org.calypsonet.terminal.card.spi.CardRequestSpi;

/**
 * Reader able to transmit card requests and having control over the physical channel.
 *
 * @since 1.0
 */
public interface ProxyReader {

  /**
   * Transmits a {@link CardRequestSpi}, applies the provided {@link ChannelControl} policy and
   * returns a {@link CardResponse}.
   *
   * <p>The APDUs ({@link org.calypsonet.terminal.card.spi.ApduRequestSpi}) contained in the {@link
   * CardRequestSpi} are sent to the card their responses ({@link ApduResponse}) are added to a new
   * list.
   *
   * <p><b>Note:</b> in case of a communication error when sending an APDU, an {@link
   * AbstractApduException} exception is thrown. Any responses from previous APDU commands are
   * attached to this exception.<br>
   * This allows the calling application to be tolerant to card tearing and to retrieve the partial
   * response to the {@link CardRequestSpi}.
   *
   * @param cardRequest The card request.
   * @param channelControl The channel control policy to apply.
   * @return A not null reference.
   * @throws ReaderBrokenCommunicationException If the communication with the reader has failed.
   * @throws CardBrokenCommunicationException If the communication with the card has failed.
   * @throws UnexpectedStatusCodeException If any of the APDUs returned an unexpected status code
   *     and the card request specified the need to check them.
   * @since 1.0
   */
  CardResponse transmitCardRequest(CardRequestSpi cardRequest, ChannelControl channelControl)
      throws ReaderBrokenCommunicationException, CardBrokenCommunicationException,
          UnexpectedStatusCodeException;

  /**
   * Releases the communication channel previously established with the card.
   *
   * @throws ReaderBrokenCommunicationException If the communication with the reader has failed.
   * @since 1.0
   */
  void releaseChannel() throws ReaderBrokenCommunicationException;
}
